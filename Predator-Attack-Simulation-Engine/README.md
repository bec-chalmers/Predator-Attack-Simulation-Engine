# Predator-Attack-Simulation-Engine
This console-based application is a simulation engine to model predator-prey interactions and conduct cost-benefit analyses on livestock protection.

## Installation Guidelines
### Software Requirements 
There are no external dependencies or database setup required for this application.

| Requirement                    | Version / Notes                         |
| ------------------------------ |-----------------------------------------|
| **Java** | Version **23.x** or higher              |
| **Encoding**                   | UTF-8                                   |
| **Libraries**                  | None — only uses standard Java packages |

### Data Files
The system stores and reads predator types, and their associated danger factor per Australian state, via the 'predators.txt' file.

The system writes a viability report, containing farm information, recommended number of alpaca guards, and financial and statistical data, to 'alpacaSheepGuardViability.txt'.

### Project Setup Instructions 
1. Open your terminal and navigate to the file location of the project.
2. Enter 'javac AlpacaSheepGuards.java' to compile the program.
3. Enter 'java AlpacaSheepGuards' to run the program.