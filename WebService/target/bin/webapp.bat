@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\org\apache\cxf\cxf-rt-frontend-jaxws\2.4.2\cxf-rt-frontend-jaxws-2.4.2.jar;"%REPO%"\xml-resolver\xml-resolver\1.2\xml-resolver-1.2.jar;"%REPO%"\asm\asm\3.3\asm-3.3.jar;"%REPO%"\org\apache\cxf\cxf-api\2.4.2\cxf-api-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-common-utilities\2.4.2\cxf-common-utilities-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-core\2.4.2\cxf-rt-core-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-bindings-soap\2.4.2\cxf-rt-bindings-soap-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-tools-common\2.4.2\cxf-tools-common-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-databinding-jaxb\2.4.2\cxf-rt-databinding-jaxb-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-bindings-xml\2.4.2\cxf-rt-bindings-xml-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-frontend-simple\2.4.2\cxf-rt-frontend-simple-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-ws-addr\2.4.2\cxf-rt-ws-addr-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-transports-http\2.4.2\cxf-rt-transports-http-2.4.2.jar;"%REPO%"\org\apache\cxf\cxf-rt-transports-common\2.4.2\cxf-rt-transports-common-2.4.2.jar;"%REPO%"\org\springframework\spring-web\3.0.5.RELEASE\spring-web-3.0.5.RELEASE.jar;"%REPO%"\org\eclipse\jetty\jetty-server\8.0.0.RC0\jetty-server-8.0.0.RC0.jar;"%REPO%"\org\mortbay\jetty\servlet-api\3.0.20100224\servlet-api-3.0.20100224.jar;"%REPO%"\org\eclipse\jetty\jetty-continuation\8.0.0.RC0\jetty-continuation-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-http\8.0.0.RC0\jetty-http-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-io\8.0.0.RC0\jetty-io-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-webapp\8.0.0.RC0\jetty-webapp-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-xml\8.0.0.RC0\jetty-xml-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-util\8.0.0.RC0\jetty-util-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-servlet\8.0.0.RC0\jetty-servlet-8.0.0.RC0.jar;"%REPO%"\org\eclipse\jetty\jetty-security\8.0.0.RC0\jetty-security-8.0.0.RC0.jar;"%REPO%"\com\sun\xml\bind\jaxb-impl\2.2.4-1\jaxb-impl-2.2.4-1.jar;"%REPO%"\javax\xml\bind\jaxb-api\2.2.3\jaxb-api-2.2.3.jar;"%REPO%"\javax\xml\stream\stax-api\1.0-2\stax-api-1.0-2.jar;"%REPO%"\javax\activation\activation\1.1\activation-1.1.jar;"%REPO%"\org\apache\cxf\cxf-bundle-jaxrs\2.4.2\cxf-bundle-jaxrs-2.4.2.jar;"%REPO%"\org\apache\ws\xmlschema\xmlschema-core\2.0\xmlschema-core-2.0.jar;"%REPO%"\org\codehaus\woodstox\woodstox-core-asl\4.1.1\woodstox-core-asl-4.1.1.jar;"%REPO%"\org\codehaus\woodstox\stax2-api\3.1.1\stax2-api-3.1.1.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-stax-api_1.0_spec\1.0.1\geronimo-stax-api_1.0_spec-1.0.1.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-annotation_1.0_spec\1.1.1\geronimo-annotation_1.0_spec-1.1.1.jar;"%REPO%"\org\apache\neethi\neethi\3.0.1\neethi-3.0.1.jar;"%REPO%"\wsdl4j\wsdl4j\1.6.2\wsdl4j-1.6.2.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-activation_1.1_spec\1.1\geronimo-activation_1.1_spec-1.1.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-javamail_1.4_spec\1.7.1\geronimo-javamail_1.4_spec-1.7.1.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\springframework\spring-beans\3.0.5.RELEASE\spring-beans-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-core\3.0.5.RELEASE\spring-core-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-asm\3.0.5.RELEASE\spring-asm-3.0.5.RELEASE.jar;"%REPO%"\commons-logging\commons-logging\1.1.1\commons-logging-1.1.1.jar;"%REPO%"\org\springframework\spring-context\3.0.5.RELEASE\spring-context-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\3.0.5.RELEASE\spring-aop-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\3.0.5.RELEASE\spring-expression-3.0.5.RELEASE.jar;"%REPO%"\org\slf4j\slf4j-api\1.6.1\slf4j-api-1.6.1.jar;"%REPO%"\org\apache\geronimo\specs\geronimo-servlet_3.0_spec\1.0\geronimo-servlet_3.0_spec-1.0.jar;"%REPO%"\javax\ws\rs\jsr311-api\1.1.1\jsr311-api-1.1.1.jar;"%REPO%"\org\codehaus\jettison\jettison\1.3\jettison-1.3.jar;"%REPO%"\org\slf4j\slf4j-simple\1.6.2\slf4j-simple-1.6.2.jar;"%REPO%"\org\chamerling\heroku\heroku-cxf-jaxws\1.0-SNAPSHOT\heroku-cxf-jaxws-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="webapp" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" org.chamerling.heroku.jetty.JettyServer %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
