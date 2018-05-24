FreeIPAUserTests
================

This a repo that uses CLI to write users to FreeIPA.

The pom.xml's are pretty bare right now.


How to run
----------
You need to be on a machine or vm that is enrolled as a client with admin privileges to be able to get this to work.

Then you need to kinit as your admin user:

`kinit $USER@IPA_REALM`

For right now(while I figure out how to run the project with Maven) open the project in your favorite IDE and run the 
Test class in `UserTests/src/main/test/java/`.

