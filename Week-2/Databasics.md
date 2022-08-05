# Databasics

## Keywords

1. Database
   - an organized collection of structured information or data digitally/electronically stored in a machine somewhere (in our case a machine owned by Amazon)
2. RDS
   - Relational Databases
   - They store your data in tables that are dependent on each other
   - Based on relational model a mathematical model where relations = tables (as we know it)
3. Database Schema
   - essentially the blueprint of the db that describes how data relate to database and other data models
   - does not actually contain data
   - defines how data is organized in a relational db
4. SQL
   - Structured Query Language
   - specification for a language used to interact with the db
   - It is a programming language used by nearly all relational databases to query, manipulate, and define data, and to provide access control.
   - declared language, you say what you want, actual details of how it accomplishes tasks are optimized by the sql engine
5. SQL Sublanguages
   - DDL (Data defn lang), DML (Data manipulation lang), DQL (Data Query lang), DCL (Data control language), TCL (transaction control language)
   - categorization of commands that you can execute against a database to manipulate the data it holds, alter it's structure/schema, manage users, etc
6. SQL Dialects
   - vendor specific implementation of SQL
7. Constraints
   - rules that you give columns of your table so that the data in them conforms to those rules
   - guidelines for the data
   - unique, not null, check, primary key (not null + unique), foreign key, data type
8. Common data types in PostgreSQL
   - varchar(character_limit), text, int, timestamp, float, boolean
9. Relational Multiplicity

- defines relationship between tables, 1-1, 1-m, m-m
- you actually establish these relationships by keys, join tables

10. Primary Keys
    - for records, must be unique, to identify each record uniquely
