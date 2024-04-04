# Student`s Capital

This is a realization of the solution to the [task Student`s Capital](TASK.md).
> Approximate lead time: 0.5 hours

### Requirements
* Java 17

## How to build and run

The first step is to clone the repository.
```bash
git clone https://github.com/Danilbel/students-capital-test-task.git
```

Then go to the project folder.
```bash
cd students-capital-test-task
```

### Build
To build the project you need to execute the command.
```bash
./gradlew clean jar
```

### Run
To run the project you need to execute the command.
```bash
java -jar build/libs/students-capital-1.0.jar <N> <C> <gains_array> <prices_array>
```
Where:
* `<N>` is the maximum number of laptops
* `<C>` is the starting capital
* `<gains_array>` is the array of gains
* `<prices_array>` is the array of prices

## Example result
Example of running the program:
```bash
java -jar build/libs/students-capital-1.0.jar 3 100 "30, 40.50, 70.39, 20, 10" "10, 20.2, 50.50, 15, 7"
```
**Output:**
```
Capital: 160.19
```