# cupet-frontend
This is the front-end portion of our group project.

To be able to interact with the backend API, you must run an instance of the backend on your local machine. 
The Android VM runs on a virtual network. For the Android VM to be able to see the instance of the backend, set `RoutesStore.ROOT_ROUTE` to `http://<your local ip address>:8080`.

All tests are available in the `androidTest/com.example.cupetfrontend/` directory. Please note that our tests rely on you running an instance of the android emulator.
