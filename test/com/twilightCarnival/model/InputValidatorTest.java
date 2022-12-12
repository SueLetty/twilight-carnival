package com.twilightCarnival.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {

  InputValidator validator;
  String inputPickup;
  String inputMap;
  String inputNavi;

  @Before
  public void setUp() throws Exception {
    validator = new InputValidator();
    inputPickup = "pickup key";
    inputMap = "opEn map";
    inputNavi = "walk North";
  }

  @Test
  public void isValid_checking_valid_input_strings_true() {
    assertTrue(validator.isValid(inputPickup));
    assertTrue(validator.isValid(inputMap));
    assertTrue(validator.isValid(inputNavi));
  }

  @Test
  public void isValid_checking_wrong_input_strings() {
    String invalid1 = "sprint Northwest";
    String invalid2 = "go SouthEast";

    assertFalse(validator.isValid(invalid1));
    assertFalse(validator.isValid(invalid2));
  }

  @Test
  public void getInput_checking_correct_input_is_stored() {
    validator.isValid(inputPickup);
    String[] expected = {"pickup", "key"};
    assertArrayEquals(expected, validator.getInput());

    validator.isValid(inputMap);
    String[] expected2 = {"open", "map"};
    assertArrayEquals(expected2, validator.getInput());

    validator.isValid(inputNavi);
    String[] expected3 = {"go", "NORTH"};
    assertArrayEquals(expected3, validator.getInput());
  }
}