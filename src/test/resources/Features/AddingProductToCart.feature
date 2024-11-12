Feature: Adding product to cart without chosen size
  Scenario: User tries to add a product to cart without chosen size

    Given user is on the product details page
    When user tries to add item to cart without chosen size
    Then alert no chosen size is displayed

  Scenario: User adds a product to cart with chosen size and proceed to checkout

    Given user is on the product details page
    When user clicks on item size
    And adds item to the cart
    Then window with information about added item to cart is displayed