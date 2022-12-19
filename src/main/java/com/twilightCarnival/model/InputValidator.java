package com.twilightCarnival.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * InputValidator checks user's input and assigns to a field proper input choices if valid.
 */
public class InputValidator {

  private final String[] input = new String[2];
  private String inputVerb;
  private String inputNoun;
  private final String[] pickUpVerbs = {"pickup", "acquire", "search", "grab", "pick-up"};
  private final String[] mapVerbs = {"use", "open", "view", "render"};
  private final String[] navigationVerbs = {"go", "travel", "walk", "move", "run", "sprint"};
  private final String[] pickupNouns = {"map", "key", "master key", "keys", "bronze key", "gold key",
      "silver key"};
  private String[] combatNouns = null;
  private final String[] combatNumbers = {"1", "2", "3", "4"};
  private final Directions[] directions = Directions.values();

  /**
   * isValid Method takes input string and populates private field that hold a proper input.
   *  It does not handle conjunctions.
   * @param input String the user inputs for an action of using an item or moving.
   * @return boolean that states the input is valid and the input is put in a String[] input field.
   */
  public boolean isValid(String input) {
    boolean result = false;
    boolean verbCondition = false;
    boolean nounCondition = false;

    String[] unfilteredString = input.split(" ");

    if (Arrays.asList(combatNumbers).contains(unfilteredString[0])){
      System.out.println("I should try to \"use\" an [item].");
      result = false;
    }else {
      for (String str : unfilteredString) {
        if(Objects.equals(str, "") || Objects.equals(str, " ")){
          break;
        }
        if (!verbCondition) {
          verbCondition = isAValidVerb(str);
        } else if (!nounCondition) {
          nounCondition = isAValidNoun(str);
        }
      }
      if (verbCondition && nounCondition) {
        this.input[0] = inputVerb;
        this.input[1] = inputNoun;

        if (validCombination()) {
          result = true;
        } else {
          System.out.printf("> I do not think I can \"%s %s.\" I should try something different.\n", this.input[0], this.input[1]);
        }
      } else {
        System.out.println("> I must not be in the right headspace. Maybe I should go about this in another way.");
        System.out.println("> Why do I find myself in situations where I need " +"\u001B[32m" + "help" + "\u001B[0m" + ".");
        result = false;
      }
    }
    return result;
  }

  /**
   * getInput() gets the field String[] input, that holds 2 strings for proper verb[0] and noun[1].
   *
   * @return String[] input. [0] verb, [1] noun.
   */
  public String[] getInput() {
    return input;
  }

  /**
   * isAValidVerb(String verb) called to check if input is a proper whitelisted verb to be assigned
   * to String[] input;
   *
   * @param verb String value to be checked if it is a whitelisted verb.
   * @return boolean value if the string passed is whitelisted verb.
   */
  private boolean isAValidVerb(String verb) {
    boolean isVerb = false;
    if (verb.equalsIgnoreCase("use") && combatNouns.length > 0){
      inputVerb = "use";
      isVerb = true;
    } else if (Arrays.asList(pickUpVerbs).contains(verb.toLowerCase())) {
      inputVerb = "pickup";
      isVerb = true;
    } else if (Arrays.asList(mapVerbs).contains(verb.toLowerCase())) {
      inputVerb = "open";
      isVerb = true;
    } else if (Arrays.asList(navigationVerbs).contains(verb.toLowerCase())) {
      inputVerb = "go";
      isVerb = true;
    }

    return isVerb;
  }

  /**
   * isAValidNoun(String noun) called to check if input is a proper whitelisted noun to be assigned
   * to String[] input.
   *
   * @param noun String value to be checked if it is a whitelisted noun.
   * @return boolean value if the string passed is whitelisted noun.
   */
  private boolean isAValidNoun(String noun) {
    boolean isNoun = false;
    if (Arrays.asList(pickupNouns).contains(noun.toLowerCase())) {
      if (noun.equalsIgnoreCase("key")){
        inputNoun = "master key";
      }
      else {
        inputNoun = noun.toLowerCase();
      }
      isNoun = true;
    } else if (containsDirection(noun)) {
      inputNoun = noun.toUpperCase();
      isNoun = true;
    } else if (Arrays.asList(combatNouns).toString().contains(noun.toLowerCase())) {
      inputNoun = noun.toLowerCase();
      isNoun = true;
    }
    return isNoun;
  }

  /**
   * validCombination that will check for valid input combination.
   *  Current valid combinations is tied to keywords given to input[0] during isAValid[Noun/Verb]()
   *  methods.
   * @return boolean if the combination is valid/invalid.
   */
  private boolean validCombination() {
    boolean result = false;
    if (input[1].equalsIgnoreCase("map") && inputVerb.equalsIgnoreCase("use")){
      input[0] = "open";
    }
    switch (input[0]) {
      case "pickup":
        if (Arrays.asList(pickupNouns).contains(input[1].toLowerCase())) {
          result = true;
        }
        break;
      case "open":
        if (input[1].equals("map")) {
          result = true;
        }
        break;
      case "go":
        if (Arrays.asList(directions).toString().contains(input[1].toUpperCase())) {
          result = true;
        }
        break;
      case "use":
        if(Arrays.asList(pickupNouns).contains(input[1].toLowerCase())
            || Arrays.asList(combatNouns).contains(input[1].toLowerCase())){
          result = true;
        }
        break;
      default:
        result = false;
    }
    return result;
  }

  /**
   * generateCombatTools is called to populate the combatNouns for proper input to be used for combat.
   * Dynamic for per room.
   * @param station for which the tools and monster are, get the information to assign to field.
   */
  public void generateCombatTools(Station station){
    String[] tools = station.getTools();
    if (tools != null){
      for (int i = 0; i < tools.length; i++){
        tools[i] = tools[i].toLowerCase();
      }
    }
    combatNouns = tools;
  }

  /**
   * Check if a combat tool exists in the dynamic generated combatNouns array. Might be redundant.
   * @param noun weapon/tool to be used against a monster.
   * @return if the tool exists in the room.
   */
  public boolean isCombatTool(String noun){
    boolean result = false;
    if(combatNouns == null){
      result = false;
    }

    assert combatNouns != null;
    if(Arrays.asList(combatNouns).contains(noun.toLowerCase())){
      result = true;
    }
    return result;
  }

  /**
   * containsDirection() compares the enum directions explicitly.
   * @param direction String value of Heading NORTH,SOUTH,EAST,WEST.
   * @return bool if the direction is contained in directions field.
   */
  private boolean containsDirection(String direction){
    boolean result = false;
    for (Directions d : directions) {
      if(d.toString().equalsIgnoreCase(direction)){
        result = true;
      }
    }

    return result;
  }
}
