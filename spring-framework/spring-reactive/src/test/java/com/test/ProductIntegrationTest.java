package com.test;

import com.learning.controller.ProductController;
import com.learning.dto.ProductDto;
import com.learning.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
@ComponentScan(basePackages = "com.learning")
 public class ProductIntegrationTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductService service;

    @Test
    public void testSaveProduct(){
        Mono<ProductDto> productDto=Mono.just(new ProductDto("100","mobile",1,20000));
        when(service.saveProduct(productDto)).thenReturn(productDto);
        webTestClient.post().uri("/products/save")
                .body(Mono.just(productDto),ProductDto.class)
                .exchange()
                .expectStatus()
                .isOk();
    }

    @Test
    public void testFindAllProducts(){
        Flux<ProductDto> productListFlux=Flux.just(new ProductDto("100","mobile",1,20000),
                new ProductDto("101","TV",1,50000));
        when(service.findAllProducts()).thenReturn(productListFlux);
        Flux<ProductDto> response= webTestClient.get().uri("/products/")
                .exchange()
                .expectStatus().isOk()
                .returnResult(ProductDto.class)
                .getResponseBody();

        StepVerifier.create(response)
                .expectSubscription()
                .expectNext(new ProductDto("100","mobile",1,20000))
                .expectNext(new ProductDto("101","TV",1,50000))
                .verifyComplete();
    }

    @Test
    public void findProductById(){
        Mono<ProductDto> productDtoMono=Mono.just(new ProductDto("100","mobile",1,20000));
        when(service.findProductById(any())).thenReturn(productDtoMono);
        Mono<ProductDto> response= webTestClient.get()
                .uri("/products/100")
                .exchange()
                .expectStatus().isOk()
                .returnResult(ProductDto.class)
                .getResponseBody().next();

        StepVerifier.create(response)
                .expectSubscription()
                .expectNextMatches(p->p.getName().equals("mobile"))
                .verifyComplete();

    }

    @Test
    public void updateProduct(){
        Mono<ProductDto> productDtoMono=Mono.just(new ProductDto("100","mobile",1,20000));
        when(service.updateProduct(any(),any())).thenReturn(productDtoMono);
        Mono<ProductDto> response=webTestClient.put()
                .uri("/products/update/100")
                .body(Mono.just(productDtoMono),ProductDto.class)
                .exchange()
                .returnResult(ProductDto.class)
                .getResponseBody().next();

        StepVerifier.create(response)
                .expectSubscription()
                .expectNextMatches(p->p.getPrice()==20000)
                .verifyComplete();
    }

    @Test
    public void deleteProduct(){
        given(service.deleteProductById(any())).willReturn(Mono.empty());
        webTestClient.delete()
                .uri("/products/delete/100")
                .exchange()
                .expectStatus().isOk();
    }
}
