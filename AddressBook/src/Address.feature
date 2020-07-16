#Please Do not change Feature Templet
Feature: Address Book
   
  #Please Do not change Scenario Templet
  Scenario: Add addresses
    #Please Do not change Given Templet
    Given Launch the application 
    When address details are added
    | NickName | Contact Name | Company | City | Country | Type |
    | Poj | Pooja | Wipro | Chennai | India | Sender |
    | Rum | Ramya | HCL | Coimbatore | India | Recipient |
    | laa | Lavanya | Skava | Banglore | India | Sender |
    When addresses are deleted
    | NickName | Contact Name | Company | City | Country | Type |
    | Poj | Pooja | Wipro | Chennai | India | Sender |
    Then all addresses should be displayed to the right
    | NickName | Contact Name | Company | City | Country | Type |
    | Rum | Ramya | HCL | Coimbatore | India | Recipient |
    | laa | Lavanya | Skava | Banglore | India | Sender |