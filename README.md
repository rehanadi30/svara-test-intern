# Svara Android Test
## Goal: Create App radio streaming

## Components
- UI App
- Integrate with API (Register, Login, Guest Mode, Radio List)
- Radio streaming player
  
## Requirements
- Develop App using Android Studio Java / Kotlin
- Radio list should be use <a href="https://developer.android.com/guide/topics/ui/layout/recyclerview"> RecyclerView </a>
- Data transaction should be use  <a href="https://square.github.io/retrofit/">Retrofit</a>

## Rules
- App must be finished in 1 day at working hour
- App must be stored in git


## Information
- Design App <a href="https://www.figma.com/file/ZXvlqlDo2mDdhCv4dcnfYaLh/test-svara?node-id=0%3A1">Figma</a>
- Sample App <a href="https://gitlab.suararadio.com/test/svara-android-test/blob/master/SvaraTestAndroidSample.apk">SvaraTestAndroid.apk</a>
- Simple API Docs <br/>
  BaseUrl: `https://api.svara.id/sample/api/`
  ```
    # Radio Endpoint

    ## Get all radio
    GET /radios?access_token="longTokenToAccessData"

    ## Get radio by id
    GET /radios/:id?access_token="longTokenToAccessData"

    ## Add new radio
    POST /radios?access_token="longTokenToAccessData"

    ## Edit radio by id
    PUT /radios/:id?access_token="longTokenToAccessData"

    ## Delete radio by id
    DELETE /radios/:id?access_token="longTokenToAccessData"


    # User Endpoint

    ## Register new user
    POST /users/register

    ## User login
    POST /users/login

    ## Guest Mode
    POST /users/guest-mode
  ```
- Sample response login / guest
    ```
    {
        "id": "5e2e687b2675a060cb34c553",
        "username": "guest-1580099707495",
        "token": "longTokenToAccessData",
        "expire": 1580100308
    }
    ```
- Sample response radioList
    ```
    [
        {
            "name": "Zora FM Bandung",
            "city": "Bandung",
            "frequency": 90.1,
            "logo": "aws:images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
            "stream": "http://118.91.131.19:8000/zora",
            "website": "http://www.zorafm.com",
            "id": 9,
            "images": {
                "image64": "https://d3qhpgw8o2ryav.cloudfront.net/64x64/filters:fill(white,1)/images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
                "image150": "https://d3qhpgw8o2ryav.cloudfront.net/150x150/filters:fill(white,1)/images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
                "image300": "https://d3qhpgw8o2ryav.cloudfront.net/300x300/filters:fill(white,1)/images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
                "image640": "https://d3qhpgw8o2ryav.cloudfront.net/640x640/filters:fill(white,1)/images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
                "placeholder": "https://d3qhpgw8o2ryav.cloudfront.net/50x50/filters:blur(30):fill(white,1)/images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147",
                "imageOri": "aws:images/svara-radio-logo/download/573e8bfd0c3f8b20491c8147"
            }
        },
        {
            "name": "KLite FM Bandung",
            "city": "Bandung",
            "frequency": 107.1,
            "logo": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
            "stream": "http://stream.suararadio.com:8000/bandung_klitefm_mp3",
            "website": "http://www.1071klitefm.com",
            "id": 18,
            "images": {
                "image64": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
                "image150": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
                "image300": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
                "image640": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
                "placeholder": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189",
                "imageOri": "http://apibeta.svara.id:3000/api/images/svara-radio-logo/download/573e8cb10c3f8b20491c8189"
            }
        }
    ]
    ```