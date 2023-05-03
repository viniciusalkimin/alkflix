# alkflix
Personal project, using Java, Spring and H2 Database.

### Stack:
`Java11`
`SpringBoot.2.7.10`
`SpringDataJPA`
`SpringSecurity`
`Maven`
`H2DB:alkflix`
`OAuth`
`HMAC256`

#### For any request is needed authentication on endpoint `'/login'` using the datas: `Username: adm@alkflix.com`, `Password: 123456` for generation of a JWT Token.

## EndPoints for Movies:
Mapped to: `{localhost:8080}/movies`

## Resources

### List All
-Method: `GET`

-Return: `Page of Movies(OrderedBy=id, Size=5)`

### Get One 
-Method: `GET/{id}`

-Return: `ResponseEntity with the Movie`


### Delete One 
-Method: `DELETE/{id}`

-Return: `ResponseEntity with the Movie`

### New
-Method: `POST`

-ContentOfBody: `Movie`

-Return: `ResponseEntity with HTTP Status OK`


### Update
-Method: `PUT`

-ContentOfBody: `Movie`

-Return: `ResponseEntity with the Movie`



## EndPoints for Series:
Mapped to: `{localhost:8080}/series`

## Resources

### List All
-Method: `GET`

-Return: `Page of Series(OrderedBy=id, Size=5)`

### Get One 
-Method: `GET/{id}`

-Return: `ResponseEntity with the Serie`


### Delete One 
-Method: `DELETE/{id}`

-Return: `ResponseEntity with the Serie`

### New
-Method: `POST`

-ContentOfBody: `Serie`

-Return: `ResponseEntity with HTTP Status OK`


### Update
-Method: `PUT`

-ContentOfBody: `Serie`

-Return: `ResponseEntity with the Serie`

 
