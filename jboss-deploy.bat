:: Adapter les valeurs des 2 variables.
set jboss_root=C:\servers\jboss-eap-7.4
set war_archive_name=Demo-JSF-1.0.0.war

cd %jboss_root%\bin
cmd /c jboss-cli.sh --connect command=:shutdown
timeout /t 3
cd %jboss_root%\standalone
@RD /S /Q deployments
mkdir deployments
cd %~dp0
cmd /c mvn clean install
cd target
copy %war_archive_name% %jboss_root%\standalone\deployments
cd %jboss_root%\bin
cmd /c standalone.bat
