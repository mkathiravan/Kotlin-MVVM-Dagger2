# Kotlin-MVVM-Dagger2

## Dagger2

It is dependency injection framework.

It provides an allegiant solution to tight coupling problems.

Dependency Injection is based on concept called "Inversion of control". This concept means a class should get its dependencies from external class ratheer than instantiating them in the class.

## 3 Major Parts of Dagger2

i) Dependency Provider

ii) Dependency Consumer

iii) Component

### Dependency Provider:

The class that is responsible for providing dependencies is annotated as @Module and the methods that provides dependency in this class to be annotated as @Provides.

### Dependency Consumer:

It is a class where we need to instantiate the objects. But we dont need to instantiate it with the new keyword. Do not need to get it as an argument. But dagger will provide the dependency and for this, we just need to annotate the object with @Inject

### Component:

Acts as a interface between dependency consumer and dependency provider annotated with @Component and it is an interface.
