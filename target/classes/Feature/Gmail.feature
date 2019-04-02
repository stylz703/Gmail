Feature: Gmail login functionality



@Smoke @Linkedin
Scenario Outline: Testing Gmail login success test case

Given User at homepage
When User enter firstname "<firstname>"
When User enter lastname "<lastname>"
When User enter username "<username>"
When User enter password "<password>"
When User enter confirm "<confirm>"
Then User click next
Then User will see error message

Examples:
|firstname|lastname|username|password|confirm|
|Bryan|almanza|dmv703|1122d3|1122d3|
|tiffany|kines|tiff112|tyty112|tyty112|
|ace|maximus|acey113|qwert11|qwert11|