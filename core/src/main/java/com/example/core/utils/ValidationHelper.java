package com.example.core.utils;

import java.util.Objects;

public class ValidationHelper {

  private ValidationHelper() {

  }

  public static boolean fieldHasValidValue(final String fieldValue) {
    return !Objects.isNull(fieldValue) && !fieldValue.isEmpty();
  }
}
