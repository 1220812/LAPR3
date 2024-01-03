# Supplementary Specification (FURPS+)

## Functionality

* Authentication: Most of the sensitive information must only be available by authorized users.

* Communication: Alerts regarding relevant occurrences should be sent to the user.

* Error management: Error messages should be clear and give information to the user regarding what caused it and how to possibly avoid it.

* Event management: Users should be able to create, delete and edit events they have permissions to (i.e. registration of operations)

* Licensing: The application should be fully licensed to be used legally.

* Localisation: The application should be available in English as its current use.

* Online help: There must be FAQs, tutorials and manuals available for download online regarding the use of the application.

* Persistence: The persistence should be reliable, all information should be secure and easily retrievable.

* Printing: The application information should be easily printable by the user.

* Reporting: Reporting isn't exactly a must in the application, but some aspects of the system should be available to be generated.

* Security: Register and login systems: Secure password system (passwords should be over seven alphanumeric characters, including three capital letters and two digits).

* Workflow: Workflow should be efficient to all users, so it must be customizable enough to any users needs.

* Tracking Fields: This functionality involves creating a digital map of the agricultural land. It allows the user to define and manage individual fields, specifying their sizes, locations, and purposes (e.g., crop types to be planted). Each field should have its unique identifier, and the user should be able to track changes over time.

* Crop Management: Within each field, you need to manage the cultivation of different crops. This includes recording the type of crops, planting dates, expected harvest dates, and any specific requirements for each crop. The user may also want to track crop rotation to maintain soil health.

* Irrigation Management: The system should help manage irrigation for the fields. This involves tracking irrigation schedules, the amount of water used, and methods (drip, sprinkler, etc.). The user might want to incorporate weather data to optimize irrigation based on soil moisture and weather conditions.

* Weather Data: The system should integrate with weather data sources to provide real-time and historical weather information. This data can help farmers make informed decisions about planting, irrigation, and other farming activities based on weather patterns and forecasts.

* Commercialization: This functionality deals with managing the sale and distribution of agricultural products. It includes features like creating product listings, managing orders, tracking inventory, and coordinating deliveries to customers. It can also incorporate pricing, invoicing, and payment processing.

* Planting and Harvesting Dates: The user should be able to record specific planting and harvesting dates for each crop in each field. This data helps in planning and scheduling activities throughout the agricultural season.

* Soil Condition Monitoring: The system can integrate with soil sensors or manually recorded data to track soil conditions. This may include factors like soil pH, nutrient levels, and moisture content. It can help in making decisions about fertilization and other soil treatments.

* Crop Rotation: Crop rotation is a critical aspect of organic agriculture to maintain soil health and prevent disease. The system can suggest and track crop rotation plans to ensure the optimal use of fields.

* Irrigation Optimization: Utilize weather data and soil moisture levels to optimize irrigation schedules, ensuring that water is used efficiently and sustainably.

## Usability 

* It will implement unit tests for all methods (except for Input/Output methods);
* The software should be user-friendly and easy to navigate;
* The application must support the English language.

## Reliability

* The system must run 7 days a week, 24 hours a day;
* The system must have as few failures as possible and if they do happen, they should be resolved as quickly as possible;
* The software should be reliable and stable, with minimal downtime;
* The software should be secure and protect confidential information.

## Performance

* The system must respond quickly to all operations;
* The application should consume little memory and CPU;
* The software should be able to handle a large number of transactions and users.

## Supportability

* The app will support the English language;
* It should be easy to maintain and to update the system;
* The software should have good documentation and customer support;
* The software should be compatible with future updates;
* The software application should also be conceived having in mind that it can be further commercialized to other companies.

### Design Constraints

* The programming languages will be Java, PL/SQL, C language and Assembly;
* The unit tests should be implemented using the JUnit 5 framework;
* The JaCoCo plugin will be used to generate the coverage report.

### Physical Constraints

* The system must use a database to store and manage data, with appropriate backups and redundancy measures in place;
* The application will be optimized for fast loading times.