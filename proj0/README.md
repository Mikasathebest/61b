https://sp18.datastructur.es/materials/proj/proj0/proj0

# 1. compile java files:
javac NBody.java

# 2. simulate planets
java NBody 157788000.0 25000.0 data/planets.txt

### Explain
args[0]: T: Total run time. 

args[1]: dt: update delta time. 

args[3]: file to read which contains planets infomation. 

### try more simulations
e.g:
java NBody 157788000.0 25000.0 data/binaryStars.txt
