import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getFirestore } from "firebase/firestore"
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
export const db = getFirestore(app)
export const auth =getAuth()
