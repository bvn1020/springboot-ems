# springboot-ems
Employee Management System

## Environment

- Language: Java
- Framework: SpringBoot 2
- Database: Microsoft SQL Sever 2019

## Setup Guide

1. Clone project then import as Maven Project using Eclipse IDE
2. Create database using script file in script/create_database.sql
3. Run SpringBootDemoApplication.java, project use Hibernate to auto create table in database.

## API
- **/employees** Return all Employee
- **/teams** Return all Team and Employee belong to each team
- **/company-structure** Return company structure include Director and all Department, Team and Employee belong to each other
