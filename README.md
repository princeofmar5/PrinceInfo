PrinceInfo V1.0

PrinceInfo is a new lightweight way to display information to users on a server. 
It allows you to easily display information such as donation info, rules, plugin help, etc. 
The main intention I had when I created this was to make our spawn less clustered. 
Instead of having a bunch of signs explaining information about donations, I could just tell them to do /pinfo donate. 
Setup is easy, just add the folder and jar to your server, add a few lists following the format of the two examples included and start your server.

Commands:
  /pinfo [arg]
    - [arg] is the name of the list in the config file - '/pinfo example' would be the command for a list with the name example
  /preload
    - Reloads the config
  /plist
    - Lists the usable args

Permissions:
  princeinfo.reload
    - Gives the user permission to reload the config
	
Changelog:
V1.0
  - Initial Release