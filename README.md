# automation-bdd

**Tools yang dibutuhkan** :
- [Java](https://www.oracle.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- IntelliJ IDEA Plugin :  [Cucumber for Java](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)
- IntelliJ IDEA Plugin : [Gherkin](https://plugins.jetbrains.com/plugin/9164-gherkin)
- [Chromedriver](https://chromedriver.chromium.org/downloads)
  or [Geckodriver](https://github.com/mozilla/geckodriver/releases)
  ( disesuaikan dengan versi chrome yang terinstall )
- [Maven](https://maven.apache.org/download.cgi)

**Langkah untuk setting :**

- Buka pom.xml dan add dependency ini
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
    
        <groupId>org.example</groupId>
        <artifactId>javaAutomation-gherkin</artifactId>
        <version>1.0-SNAPSHOT</version>
    
        <properties>
            <maven.compiler.source>19</maven.compiler.source>
            <maven.compiler.target>19</maven.compiler.target>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        </properties>
    
        <dependencies>
    
            <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
            <dependency>
                <groupId>io.cucumber</groupId>
                <artifactId>cucumber-java</artifactId>
                <version>7.13.0</version>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/junit/junit -->
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.13.2</version>
                <scope>test</scope>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
            <dependency>
                <groupId>io.cucumber</groupId>
                <artifactId>cucumber-junit</artifactId>
                <version>7.13.0</version>
                <scope>test</scope>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>4.11.0</version>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
            <dependency>
                <groupId>net.masterthought</groupId>
                <artifactId>cucumber-reporting</artifactId>
                <version>5.7.6</version>
            </dependency>
    
            <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>5.5.2</version>
            </dependency>
    
        </dependencies>
    
        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.22.0</version>
                    <configuration>
                        <testFailureIgnore>true</testFailureIgnore>
                    </configuration>
                </plugin>
                <plugin>
                    <groupId>net.masterthought</groupId>
                    <artifactId>maven-cucumber-reporting</artifactId>
                    <version>2.8.0</version>
                    <executions>
                        <execution>
                            <id>execution</id>
                            <phase>verify</phase>
                            <goals>
                                <goal>generate</goal>
                            </goals>
                            <configuration>
                                <projectName>javaAutomation-gherkin</projectName>
                                <outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
                                <cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </project>
    ```
- Tambahkan Webdriver (disini saya menggunakan ChromeDriver dan bisa di download di "https://chromedriver.chromium.org/downloads") lalu buat Directory driver dan simpan chromedriver.exe
   <img width="737" alt="Screen Shot 2021-10-23 at 14 50 28" src="https://user-images.githubusercontent.com/54229493/138548747-aa594413-2b0e-42a6-964c-306dfbcfa92e.png">

- Buat Directory "StepDef" dan "testRunner" pada src/test/java dan juga buat Directory "Features" pada src/test/resources
   
    <img width="465" alt="Screen Shot 2021-10-23 at 14 46 51" src="https://user-images.githubusercontent.com/54229493/138548839-de7dba43-6ac9-4d63-b69f-e8d53337da3c.png">


- Buat Feature file pada directory Features

- Buat java class "TestRunner" pada Directory TestRunner
    <img width="1154" alt="Screen Shot 2021-10-23 at 15 34 24" src="https://user-images.githubusercontent.com/54229493/138549343-f278f808-c7ce-4ac1-bac0-df1325e5d9d6.png">
- Setting testRunner.java seperti dibawah
    ```java
    package testRunner;
    
    import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;
    
    @RunWith(Cucumber.class)
    @CucumberOptions(features="src/test/resources/Features",
            glue= {"StepDef"},
            plugin ={"pretty","json:target/cucumber.json"},
            publish = true)
    public class TestRunner {
    }
    ```

- Untuk running tes bisa dengan command ```mvn test```via terminal

- Untuk generate report menggunakan command ```mvn verify -DskipTests``` via terminal

- Untuk melihat hasil, buka Directory target dan open file ini pada chrome
    <img width="371" alt="Screen Shot 2021-10-23 at 15 41 02" src="https://user-images.githubusercontent.com/54229493/138549577-b9e7e03a-f24d-4b84-b97d-20e29bcd644f.png">
    <img width="823" alt="Screen Shot 2021-10-23 at 15 41 34" src="https://user-images.githubusercontent.com/54229493/138549583-8b640d44-c4e3-45a1-940c-a9839bf103bf.png">

- Maka hasil dari generate test tersebut adalah seperti ini:
    <img width="1440" alt="Screen Shot 2021-10-23 at 15 41 42" src="https://user-images.githubusercontent.com/54229493/138549605-8ecefdd4-79be-41f9-99f3-efe991af5c8b.png">

Referensi :
-  <a href = https://youtu.be/x59ddRRaHpE> Youtube Bincang QA </a>