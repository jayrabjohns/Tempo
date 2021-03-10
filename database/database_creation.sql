USE [master]
GO

/****** Object:  Database [StudyExerciseApp]    Script Date: 10/03/2021 15:22:37 ******/
CREATE DATABASE [StudyExerciseApp]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StudyExerciseApp', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudyExerciseApp.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'StudyExerciseApp_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\StudyExerciseApp_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [StudyExerciseApp] SET COMPATIBILITY_LEVEL = 150
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StudyExerciseApp].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StudyExerciseApp] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET ARITHABORT OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StudyExerciseApp] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StudyExerciseApp] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET  DISABLE_BROKER 
GO
ALTER DATABASE [StudyExerciseApp] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StudyExerciseApp] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [StudyExerciseApp] SET  MULTI_USER 
GO
ALTER DATABASE [StudyExerciseApp] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StudyExerciseApp] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StudyExerciseApp] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StudyExerciseApp] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [StudyExerciseApp] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [StudyExerciseApp] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [StudyExerciseApp] SET QUERY_STORE = OFF
GO
USE [StudyExerciseApp]
GO

/****** Object:  Table [dbo].[Exercise_Sessions]    Script Date: 10/03/2021 15:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Exercise_Sessions](
	[user_id] [int] NOT NULL,
	[exercise_name] [varchar](50) NOT NULL,
	[exercise_time] [float] NOT NULL,
 CONSTRAINT [PK_Exercise_Sessions] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[Study_Sessions]    Script Date: 10/03/2021 15:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Study_Sessions](
	[user_id] [int] NOT NULL,
	[study_name] [varchar](50) NULL,
	[study_time] [float] NULL,
 CONSTRAINT [PK_Study_Sessions] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[User_Account]    Script Date: 10/03/2021 15:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[User_Account](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[forename] [varchar](50) NOT NULL,
	[surname] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_User_Account] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [master]
GO
ALTER DATABASE [StudyExerciseApp] SET  READ_WRITE 
GO