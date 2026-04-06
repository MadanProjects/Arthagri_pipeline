
@smoke
Feature:Org_Management    

@Organisation_myprofile
    Scenario: Myprofile verification
    Given User has navigated to Myprofile page
    When User enters all valid input fields
    And User click enter button
    Then User should get successfully message
    
    
    
@Organisationshareholder
Scenario: Shareholder ManageAccount verification
    Given User has navigated to ManageAccount page in Shareholder
    When User enters all valid fields
    And User click Submit button
    Then User should get successfull message   
    
    @Organisationstru
  Scenario: Organisation structure Verification
    Given User has navigated to Addresource page in Oraganistion structre
    When User enters all valid fields in Addresource
    And User click RegisterCompanyMember button
    Then User should get successfull entry on listing page
          
          
          
    
  
  