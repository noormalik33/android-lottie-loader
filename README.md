# LottieLoader – Android Upload Simulator 🚀

> A native Android application showcasing modern UI transitions, custom loading states, and high-fidelity Lottie animations.

![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![Language](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Android-green?style=for-the-badge)

---

## 📱 Project Overview

**LottieLoader** is a UI/UX–focused Android application that simulates a realistic file upload workflow.  
The project demonstrates how user interaction flows through **selection → loading → success feedback** using modern Android design patterns.

This app was built to practice and showcase:
- Clean layout structuring with **RelativeLayout**
- UX-friendly **progress button states**
- Smooth success feedback using **Lottie animations**

---

## ✨ Key Features

### 🎨 RelativeLayout-Based UI Design
- File card layout built using `RelativeLayout` instead of nested `LinearLayout`s  
- Precise alignment of file icon, name, and size  
- Flat view hierarchy for improved performance  

### ⏳ Custom Progress Button
Implements a multi-state UX-friendly button:
- **Idle:** “Select File” button visible  
- **Loading:** Button disabled, text hidden, progress indicator shown  
- **Success:** Button removed to reveal success animation  

### 🎬 Lottie Animation Integration
- Uses **Airbnb Lottie** for smooth vector animations  
- Displays `success_anim.json` after upload completion  
- Replaces traditional Toasts with engaging visual feedback  

### 📂 Native File Picker
- Uses `ActivityResultLauncher` with `Intent.ACTION_OPEN_DOCUMENT`  
- Allows users to select real files from device storage  

---

## 🛠️ Tech Stack

- **Language:** Java  
- **Minimum SDK:** API 24 (Android 7.0)  
- **UI Components:** Material Design 3, RelativeLayout, FrameLayout  

### 📚 Libraries
- `com.airbnb.android:lottie:6.1.0` – Vector animations  
- `com.google.android.material:material:1.11.0` – Material UI components  
- 
````
## 🚀 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/noormalik33/android-lottie-loader.git
````

2. **Open the project in Android Studio**

3. **Sync Gradle** to install dependencies

4. **Run** on an emulator or physical Android device

---

## 🎯 Learning Outcomes

* Implementing multi-state UI flows
* Working with Android activity result APIs
* Enhancing UX using animations instead of system messages
* Designing clean and scalable Android layouts

## 📄 License

This project is licensed under the **MIT License**.
See the `LICENSE` file for more details.

---


## Contributing 🤝
Contributions are welcome! Please fork the repository, make changes, and submit a pull request. Report bugs or suggest features via GitHub Issues. 🌟
Contact 📬
For questions, feedback, or collaboration, reach out to:

---

## 👨‍💻 Developer

**Noor Malik**

IT Student  
📍 Islamabad, Pakistan  
📧 Email: noormalik56500@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/noormalik56500/)

Social 📱

📧 Email:coreittech1@gmail.com  
📹 YouTube1: https://www.youtube.com/@CoreITTech1  
📹 YouTube2: https://www.youtube.com/@CoreITTech  
📸 Instagram: https://www.instagram.com/coreit.tech  
📘 Facebook: https://www.facebook.com/share/1AmgLDUnc9/

---

💡 If you like this project, don’t forget to star ⭐ it on GitHub!

    Happy coding! 🚀 Let’s build amazing UIs together! 💪

---

⭐ *If you found this project helpful, feel free to star the repository!*
🧠 *Created for educational and portfolio demonstration purposes.*

```

