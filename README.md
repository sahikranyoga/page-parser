# Page Parser

A page parser is a java library that has implementations to different parser implementations to parse web and RSS feed pages

### Source build steps
 1. Build using maven
 ```
 mvn versions:set -DnewVersion=1.1
 mvn clean install
 ```
 2. Install the jar into local maven repo
 ```
 mvn install:install-file -Dfile=target/page-parser-1.1.jar -DgroupId=com.sahikran -DartifactId=page-parser -Dversion=1.1 -Dpackaging=jar -DgeneratePom=true
 ```

## License

    MIT License
    
    Copyright (c) 2020, Apptastic Software
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

