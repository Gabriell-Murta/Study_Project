package com.example.core.member.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.core.exceptions.BusinessException.Codes;
import com.example.core.exceptions.ProductNotFoundException;
import com.example.core.member.gateway.MemberGateway;
import com.example.core.member.member.Member;
import com.example.core.member.usecase.CreateMemberUseCase.Request;
import com.example.core.product.gateway.ProductGateway;
import com.example.core.product.product.Product;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateMemberUseCaseTest {

  @InjectMocks
  private CreateMemberUseCase useCase;

  @Mock
  private MemberGateway memberGateway;

  @Mock
  private ProductGateway productGateway;

  private final Random rd = new Random();

  @Test
  void shouldThrowExceptionWhenProductIsNotFoundInDataBase(){
    when(productGateway.existsProduct(anyLong())).thenReturn(false);
    final Long id = rd.nextLong();
    final ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> useCase.execute(id, buildRequest()));
    assertEquals(Codes.PRODUCT_NOT_FOUND_EXCEPTION.getCode(), exception.getCode());
    assertEquals("No Subsidiary Product found with provided ID - " + id, exception.getMessage());
  }

  @Test
  void shouldCreateMemberWithSuccess(){
    when(productGateway.existsProduct(anyLong())).thenReturn(true);
    when(productGateway.findProductById(anyLong())).thenReturn(buildProduct());
    when(memberGateway.saveMember(any())).thenReturn(buildMember());

    final Member memberAfterUseCase = useCase.execute(anyLong(), buildRequest());
    assertEquals(buildMember().getName(), memberAfterUseCase.getName());
    assertEquals(buildMember().getBusinessSegment(), memberAfterUseCase.getBusinessSegment());
    assertEquals(buildMember().getDocument(), memberAfterUseCase.getDocument());
    assertEquals(buildMember().getDocumentType(), memberAfterUseCase.getDocumentType());
  }

  private CreateMemberUseCase.Request buildRequest(){
    final CreateMemberUseCase.Request request = new Request("Test Member",
        "Test Member Document",
        "Test Member Document Type",
        "Test Member Business");
    return request;
  }

  private Product buildProduct(){
    return Product.builder()
        .id(rd.nextLong())
        .name("Test Product")
        .businessSegment("Test Product")
        .build();
  }

  private Member buildMember(){
    return Member.builder()
        .id(rd.nextLong())
        .name("Test Member")
        .businessSegment("Test Member Business")
        .document("Test Member Document")
        .documentType("Test Member Document Type")
        .build();
  }
}