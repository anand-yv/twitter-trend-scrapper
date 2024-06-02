# Use the official Microsoft Windows Server Core as a parent image
FROM mcr.microsoft.com/windows/servercore:ltsc2022

# Set up environment variables for Chrome and ChromeDriver
ENV CHROME_VERSION 101.0.4951.67
ENV CHROME_DRIVER_VERSION 101.0.4951.41
ENV CHROME_DIR C:\Program Files\Google\Chrome\Application

# Install Chocolatey package manager
RUN powershell -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command \
    "Set-ExecutionPolicy Bypass -Scope Process; \
    [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; \
    iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))"

# Install OpenJDK, Chrome, and ChromeDriver using Chocolatey
RUN choco install openjdk --version=21.0.1 -y
RUN choco install googlechrome --version=$env:CHROME_VERSION -y
RUN choco install chromedriver --version=$env:CHROME_DRIVER_VERSION -y

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file and ChromeDriver to the working directory
COPY target/TwitterTrendingScraper-0.0.1-SNAPSHOT.jar /app/my-spring-boot-app.jar
COPY src/main/resources/static/chromedriver.exe /app/chromedriver.exe

# Ensure the chromedriver file is executable
RUN powershell -Command "Start-Process 'cmd.exe' -ArgumentList '/c icacls chromedriver.exe /grant Everyone:(OI)(CI)F' -NoNewWindow -Wait"

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "my-spring-boot-app.jar"]