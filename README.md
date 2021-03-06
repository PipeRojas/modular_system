# Modular System Prototype

______

URL: https://modularsystem.herokuapp.com/

## Modular System API REST

Data type handled: ***JSON***

###Resources

This API offers the followings main resources:

- users
- modules

These can be used alone like this:

| Resource | Method | Description | Parameter | Return |
| :------ | :----- | :---------- | :-------- | :------ |
| `/users` | **GET** | Returns all the registered users | | **Map < String , User >** |
| `/modules` | **GET** | Returns all the registered modules | | **Map < String , Module >** |

### Resources Components

| Resource | Method | Description | Parameter | Return |
| :------ | :----- | :---------- | :-------- | :------ |
| `/users/{userName}` | **GET** | Returns the requested user | | **User** |
| `/modules/{moduleName}` | **GET** | Returns the requested module | | **Module** |
| `/modules/mainModules` | **GET** | Returns the main modules, those which aren't submodules of any module | | **Map < String , Module >** |
| `/modules/user/{userName}` | **GET** | Returns all the modules registered with userName as its owner | | **Map < String , Module >** |
| `/modules/mainModules/{userName}` | **GET** | Returns all the main modules registered with userName as its owner | | **Map < String , Module >** |
| `/app/user` | **POST** | Saves the given Account | **Account** | |
| `/users` | **POST** | Saves the given user | **User** | |
| `/modules` | **POST** | Saves the given module | **Module** | |
| `/users/{oldUserName}` | **PUT** | Updates the selected user with the given information | **User** | |
| `/modules/{oldModuleName}` | **PUT** | Updates the selected module with the given information | **Module** | |
| `/modules/remark/{moduleName}` | **PUT** | Adds a remark to the selected module | **String** | |
| `/modules/startDocument/{moduleName}` | **PUT** | Adds a file to the start phase of the selected module | **File** | |
| `/modules/developmentDocument/{moduleName}` | **PUT** | Adds a file to the development phase of the selected module | **File** | |
| `/modules/subModule/{moduleName}` | **PUT** | Adds a remark to the selected module | **Module** | |

### URL Parameters

| Name | Type | Description |
| :----- | :--- | :---------- |
| *userName* | **String**| Name of the user |
| *moduleName* | **String**| Name of the module |
| *oldUserName* | **String**| Name of the user before modify his information |
| *oldModuleName* | **String**| Name of the module before modify his information |

### Data Form

#### User:

    {
        "name":String,
        "text":String,
        "selection":String
    }

#### Account:

    {
        "username":String,
        "password":String
    }

#### Module:

    {
        "name":String,
        "owner":User,
        "iteration":Boolean,
        "initialDate":Long,
        "remarks":[
            String
        ],
        "start":Start,
        "development":Development,
        "end":End
    }

#### Start:

    {
        "text":String,
        "selection":String,
        "frequency":Boolean,
        "estimateDate":Long,
        "documents":[
            String
        ]
    }

#### Development:

    {
        "text":String,
        "selection":String,
        "documents":[
            String
        ],
        "subModules":[
            Module
        ]
    }

#### End:

    {
        "text":String,
        "selection":String,
        "startAndDevelopmentRemarks":String
    }

_________
