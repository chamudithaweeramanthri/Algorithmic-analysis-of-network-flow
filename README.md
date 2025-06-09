Sure! Here's a professional and easy-to-read **GitHub `README.md`** file for your **Maximum Flow (Edmonds-Karp / Ford-Fulkerson Algorithm)** Java project, complete with emojis and sections:

---

```markdown
# 🚀 Maximum Flow Solver using Ford-Fulkerson (Edmonds-Karp) Algorithm

This Java project implements the **Edmonds-Karp algorithm**, a BFS-based version of the Ford-Fulkerson method to compute the maximum flow in a flow network.

📁 Input is read from a `.txt` file containing the graph, and the program outputs the maximum flow and time taken.

---

## 📌 Features

- ✅ Implements the **Ford-Fulkerson** algorithm using **BFS**
- 📊 Calculates **Maximum Flow** from Source to Sink
- 📝 Reads graph input from a file
- ⏱️ Measures execution time in milliseconds
- 👨‍💻 Modular Object-Oriented Design (OOP concepts used)

---

## 🛠️ Technologies Used

- Java ☕
- File I/O 📄
- Object-Oriented Programming 🧱

---

## 📂 Project Structure


├── Main.java                # Program entry point
├── Graph.java               # Graph structure and adjacency list
├── Edge.java                # Edge class with flow/residual logic
├── MaxFlowSolver.java       # Core max flow logic (BFS + flow update)
├── Text.java                # File parser for graph input
└── Benchmark/
└── bridge\_1.txt         # Example input file


## 📥 Input File Format

First line: number of nodes  
Following lines: edges in format → `from to capacity`

**Example (`bridge_1.txt`)**:


6
0 1 4
0 4 1
1 2 2
1 3 1
2 3 1
2 4 1
3 4 2
1 5 1
4 5 4


## ▶️ How to Run

1. ✅ Make sure you have Java installed.
2. 📌 Place your input file inside the `Benchmark/` folder.
3. 🏃‍♂️ Run the `Main.java` file.

### Output Example:

Maximum Flow: 3
Total Time Taken : 0.118 ms.

## 🧠 Concepts Used

- Ford-Fulkerson Method
- Edmonds-Karp Algorithm
- Residual Graph
- Bottleneck Capacity
- Augmenting Path
- BFS Traversal
- Java OOP (Encapsulation, Abstraction)

## 📚 References

- [Ford–Fulkerson Algorithm – Wikipedia](https://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm)
- [Edmonds–Karp Algorithm – Wikipedia](https://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm)

## 🙋‍♂️ Author

**Chamuditha**  
🎓 Undergraduate Student – Software Engineering  
📍 University of Westminster | 🇱🇰 Sri Lanka

