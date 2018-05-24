FreeIPAUserTests
================

This a repo that uses CLI to write users to FreeIPA.

The pom.xml's are pretty bare right now.

Building the project
--------------------

Check to see if you have the newest versions of JDK, Maven and Git:

```
java -version
mvn -version
git --version
```

Clone the Repository:
```$xslt
git clone https://github.com/Matthew-Beliveau/FreeIPAUserTests.git
cd FreeIPAUserTests
```

Then run:

`mvn install`

to build it.

How to run
----------
You need to be on a machine or vm that is enrolled as an IPA client with admin privileges to be able to get this to work.

Then you need to kinit as your admin user:

`kinit $USER@IPA_REALM`

Then run:

`mvn exec:java -f UserTests/Tests/pom.xml -PUserTests`

to start the tests.


