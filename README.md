## Reproduce steps

1. Run the application with `bootRun`
2. Open the browser and navigate to http://localhost:8080
3. It will redirect to the login page
4. Click the login button
5. Then you will see the error page

## It works fine without `RelativeRedirectFilter`

1. Comment out the `RelativeRedirectFilter` in `AppConfig.java`
2. Restart the application and try the steps again.
