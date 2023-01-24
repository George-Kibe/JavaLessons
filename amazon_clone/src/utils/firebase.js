// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import firebase from "firebase"
//import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAyspDZOOUIZMY1IHhhniA7LWoc_UZpnTc",
  authDomain: "clone-b9115.firebaseapp.com",
  projectId: "clone-b9115",
  storageBucket: "clone-b9115.appspot.com",
  messagingSenderId: "514313419950",
  appId: "1:514313419950:web:5bb918955bf76f2da8813f",
  measurementId: "G-VFH7X508V4"
};

// Initialize Firebase
const firebaseApp = initializeApp(firebaseConfig);
//const firebaseApp = firebase.initializeApp(firebaseConfig)
//const analytics = getAnalytics(app);
const db = firebaseApp.firestore()
const auth = firebase.auth();

export {db, auth};