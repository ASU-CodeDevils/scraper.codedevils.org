# CD Job Scraper

## Project Description

The Job Scraper Project is designed to create a comprehensive system for scraping job postings from various websites and serving the collected data through an API built with Spring Boot. The project involves multiple contributors who will each be responsible for implementing a script to scrape different job posting websites.

### How It Works

1. **Adding Websites** :

   * Users can suggest new job posting websites to be added to the scraping pipeline.
   * These suggestions are reviewed and added to the list of target websites.

1. **Contributor Workflow** :

   * Each contributor is assigned a website from the list.
   * They inspect the website to understand its structure and identify the necessary elements for scraping.
   * They then implement the scraping logic using appropriate tools and libraries.

1. **Scraping and Data Storage** :

   * The scraping service runs at scheduled intervals to collect job postings from the target websites.
   * The collected data is stored in a database for easy access and management.

1. **API Access** :

   * The stored job posting data is made available through a RESTful API built with Spring Boot.
   * Users can query the API to retrieve job postings based on various criteria.

### Getting Started

To get started with the CD Job Scraper Project, follow these steps:

1. **Clone the Repository** :

    ```shell
    git clone https://github.com/ASU-CodeDevils/scraper.codedevils.org.git
    # Or if you have ssh set up
    git clone git@github.com:ASU-CodeDevils/scraper.codedevils.org.git

    # Navigate to the cloned directory
    cd scraper.codedevils.org
    ```

1. **Set Up the Environment** :

   * Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.
   * Ensure you have Java (Version 21) and Gradle (Version 8.5) installed.
     * For UNIX systems (i.e. macOS, Linux, or Windows WSL), use [SDKMAN](https://sdkman.io/) to install the correct version of Java and Gradle.
     * **Not recommended**: For Windows systems, install [Java 21](https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe) and [Gradle 8.5](https://gradle.org/install/#manually) manually.
   * Set up your database and configure the connection in `application.properties`.

        **Database Setup:**
        * Create a new file named `compose.yaml` in the root directory of the project (i.e. `/`).
        * Copy the contents of `example-compose.yaml` into `compose.yaml` and replace the placeholders with your database credentials.

        **Application Configuration:**
        * Create a new file named `application.properties` in the `src/main/resources` directory.
        * Copy the contents of `example-application.properties` into `application.properties` and replace the placeholders with your database credentials

1. **Run the Application** :

   Using command line:

   ```shell
   ./gradlew bootRun
   ```

   If you use IntelliJ, use the `Run` menu to run the application.
   If you are using Visual Studio Code, install the extensions [Gradle for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle) and [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack).

1. **Contribute** :

   * Check the issues or the GitHub projects for available tasks.
   * Find a task that interests you and assign yourself to it. (You should only have one task assigned to you at a time.)
   * Update the `Status` column to `In Progress`.
   * Fill in the `Start Date` column with the date you assigned yourself to the task. (Note: You will have 1-week time to finish the task before it is up for grabs for anyone else.)
   * Follow the guidelines to implement the scraping logic and submit your code via a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for details.
