// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: process.env.REACT_APP_FIREBASE_KEY,
  authDomain: "tutorials-391613.firebaseapp.com",
  projectId: "tutorials-391613",
  storageBucket: "tutorials-391613.appspot.com",
  messagingSenderId: "471699193099",
  appId: "1:471699193099:web:cfa058bdb203184ba8b60e",
  measurementId: "G-BRS8LFWN93"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const auth =getAuth()
