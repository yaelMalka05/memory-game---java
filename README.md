# memory-game---java
# Memory Game Pro 🎮

A fully functional, classic Memory Game built from scratch using **Java** and the **Swing** GUI toolkit. The project demonstrates strong Object-Oriented Programming (OOP) principles, event-driven programming, and effective separation of concerns between game logic and the user interface.

## 🌟 Features

* **Two-Player Mode:** Play against a friend with dynamic turn-switching and real-time score tracking.
* **Custom Player Names:** Personalized start screen to input player names.
* **Multiple Difficulty Levels:** * Level 1: 4x4 Grid (16 cards).
    * Level 2: 4x6 Grid (24 cards) for a harder challenge.
* **Smart UI Navigation:** Utilizes `CardLayout` for seamless transitions between the Start Menu, Game Board, and End Game screens.
* **Dynamic Image Scaling:** Built-in image processor that automatically scales any uploaded card images to a uniform size (100x100), ensuring a clean and consistent grid regardless of the original image dimensions.
* **Automated Turn Management:** Utilizes Java `Timer` to handle incorrect matches, allowing a brief 1.5-second delay for players to memorize the cards before they automatically flip back.

## 🛠️ Tech Stack

* **Language:** Java
* **GUI Framework:** Java Swing & AWT

## 🏗️ Project Architecture

The application is structured to separate the game state from the visual components:

* **Core Logic (Model):** * `GameOn`: The central game manager handling turns, matching logic, and state callbacks.
    * `Board` & `Card`: Manage the data structure, shuffling algorithm, and image assignments.
    * `Player`: Tracks user names and scores.
* **User Interface (View):** * `GameFrame`: The main window acting as the container.
    * `GamePanel`, `GameStatusPanel`, `StartPanel`, `EndPanel`: Modular components displaying specific parts of the game state.
    * `CardButton`: A custom GUI component extending `JButton` that binds a visual button to a logical `Card` object.

## 🚀 How to Run

1.  Clone this repository to your local machine:
    ```bash
    git clone [https://github.com/YourUsername/MemoryGamePro.git](https://github.com/YourUsername/MemoryGamePro.git)
    ```
2.  Ensure you have the Java Development Kit (JDK) installed.
3.  **Important - Assets Folder:** Create a folder named `pic` in the root directory of the project. Add 8 images named `1.jpg` through `8.jpg` (for the card faces) and one image named `b.jpg` (for the back cover of the cards).
4.  Compile and run the `Program.java` file to start the game.

## 📸 Screenshots

*(Add your screenshots here to make the repository visually appealing)*

* **Start Screen:** `![Start Screen](link-to-image)`
* **Gameplay:** `![Gameplay](link-to-image)`
* **Victory Screen:** `![Victory Screen](link-to-image)`

## 👤 Author
**[yael/ GitHub Profile]**
