Card Game Website

To Set Up
1. Run the a H2Database.jar file
2. Maven Clean Install the Project. 
3. Move the .war file to the Wildfly server deployments
4. Get a Wildfly Server running with the standalone.xml referencing the H2 Database.
5. Go to your localhost:8080/warfilename(without extension)/
6. Enjoy.

The Website is also currently hosted at http://35.197.225.161:8080/cardGameCollectionWebsite-1.0/ if you would like to explore without the hassle of ssetting it up yourself.

You can create Cards and Users and Decks. There are a few issues with the Many to Many Database in the current version, so Cards cannot currently be added to decks.
