## Purpose

Sometimes, usage of System.out.print* methods can be restricted in projects.
This plugins finds all calls to System.out.print* methods.

## Usage

### Install maven plugin
```
mvn clean install
```

### Usage in project

In any maven project execute following

```
mvn com.github.maratkalibek.maven:bytecode-maven-plugin:1.0-SNAPSHOT:system-out-print-check
```

### Details

Following System.out.print* calls are processed

- Direct System.out.print* calls
- Via some variable. e.g. `var x = System.out; x.println("Hello");`
- If method returns directly or indirectly `System.out`