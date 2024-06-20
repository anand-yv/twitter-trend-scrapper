package com.twitter.scrapper.TwitterTrendingScraper.services;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twitter.scrapper.TwitterTrendingScraper.dtos.TrendResponseDto;
import com.twitter.scrapper.TwitterTrendingScraper.models.TrendModel;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class TwitterTrendServices {
        @Autowired
        private TrendServices trendsServices;

        @Value("${proxy.username}")
        private String proxyUsername;

        @Value("${proxy.password}")
        private String proxyPassword;

        @Value("${twitter.email}")
        private String twitterEmail;

        @Value("${twitter.username}")
        private String twitterUsername;

        @Value("${twitter.password}")
        private String twitterPassword;

        @Value("${chromeDriverFileLocation}")
        private String chromeDriverFileLocation;

        @Value("${proxy.enableProxy}")
        private boolean enableProxy;

        private WebDriver driver;
        private List<String> proxyList = List.of(
                        "45.77.195.146:3128",
                        "51.15.242.202:8888",
                        "95.216.33.245:3128",
                        "206.189.154.182:8080",
                        "194.67.37.90:3128",
                        "207.148.31.185:8080",
                        "167.99.85.79:3128",
                        "134.209.29.120:3128",
                        "138.197.222.35:8080",
                        "167.99.74.3:443",
                        "188.166.83.17:3128",
                        "165.227.30.130:3128",
                        "178.62.229.24:8080",
                        "128.199.110.230:3128",
                        "159.89.195.162:3128",
                        "178.62.193.19:3128",
                        "159.65.69.186:3128",
                        "178.128.242.71:8080",
                        "68.183.153.26:8080",
                        "134.209.112.110:3128");

        private String getRandomProxy() {
                Random random = new Random();
                return proxyList.get(random.nextInt(proxyList.size()));
        }

        private String ipaddress = getRandomProxy();

        // Method to setup the driver and navigate to the URL
        private void setup() {
                String proxyMeshUsername = proxyUsername;
                String proxyMeshPassword = proxyPassword;

                // Set up ProxyMesh proxy
                Proxy proxy = new Proxy();
                String ipaddress = getRandomProxy();
                if (enableProxy) {
                        proxy.setHttpProxy(ipaddress);
                        proxy.setSslProxy(ipaddress);
                        System.out.println("Using proxy: " + ipaddress);
                }

                ChromeOptions options = new ChromeOptions();
               if (enableProxy) {
                 options.setProxy(proxy);
                 options.addArguments("--proxy-server=" + ipaddress);
                 options.addArguments("--proxy-auth=" + proxyMeshUsername + ":" +
                 proxyMeshPassword);
               }

                System.setProperty("webdriver.chrome.driver",
                                chromeDriverFileLocation);

                driver = new ChromeDriver(options);
                // driver.manage().window().maximize();
                driver.get("https://x.com");
        }

        private void login(WebDriverWait wait) throws InterruptedException {
                try {
                        WebElement firstButton = wait.until(ExpectedConditions
                                        .elementToBeClickable(
                                                        By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div/div/div/button")));
                        firstButton.click();

                        
                        WebElement secondButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[4]/a")));
                        secondButton.click();

                        
                        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                                        "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[4]/label/div/div[2]/div/input")));
                        emailInput.sendKeys(twitterEmail);

                        
                        WebElement emailNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                        "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/button[2]")));
                        emailNextButton.click();

                        try {
                                WebElement usernameInput = wait
                                                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                                                                "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div[2]/label/div/div[2]/div/input")));
                                usernameInput.sendKeys(twitterUsername);
                        } catch (NoSuchElementException e) {
                                System.out.println("Username input element not found: " + e.getMessage());
                        }

                        
                        try {
                                WebElement usernameNextButton = wait
                                                .until(ExpectedConditions.elementToBeClickable(By.xpath(
                                                                "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/button")));
                                usernameNextButton.click();
                        } catch (NoSuchElementException e) {
                                System.out.println("Username next button element not found: " + e.getMessage());
                        }

                
                        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                                        "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")));
                        passwordInput.sendKeys(twitterPassword);

                        
                        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                        "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/button")));
                        loginButton.click();

                       
                        WebElement welcomeCloseButton = wait.until(ExpectedConditions
                                        .elementToBeClickable(
                                                        By.xpath("//*[@id=\"layers\"]/div/div[1]/div/div/div/button")));
                        welcomeCloseButton.click();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private List<String> top5Trends(WebDriverWait wait) {
                String xpathPattern = "/html/body/div[1]/div/div/div[2]/main/div/div/div/div[2]/div/div[2]/div/div/div/div[4]/div/section/div/div/div[%d]/div/div/div/div[2]";
                List<String> trendingDivs = new ArrayList<>();
                for (int i = 3; i < 8; i++) {
                        String xpath = String.format(xpathPattern, i);

                        try {
                                trendingDivs
                                                .add(wait.until(ExpectedConditions
                                                                .visibilityOfElementLocated(By.xpath(xpath)))
                                                                .getText().trim());
                        } catch (Exception e) {
                                System.out.println("Username next button element not found: " + e.getMessage());
                                
                        }
                }
                return trendingDivs;
        }

        // Method to perform actions on the page
        public TrendResponseDto actionPerform() throws InterruptedException {
                List<String> trends = new ArrayList<>();
                boolean check = false;
                try {
                        setup();
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                        login(wait);
                        trends = top5Trends(wait);
                        check = true;
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {

                        driver.quit();
                }
                LocalDateTime enDateTime = LocalDateTime.now();
                TrendResponseDto trendResponseDto = new TrendResponseDto(trends,
                                ipaddress.substring(0, ipaddress.length() - 5), enDateTime, "", check);

                if (check) {
                        TrendModel savedModel = trendsServices.saveTrends(trendResponseDto);
                        trendResponseDto.setId(savedModel.getId());
                }
                return trendResponseDto;
        }

}
