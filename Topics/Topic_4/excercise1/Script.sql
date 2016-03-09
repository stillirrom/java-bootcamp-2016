drop database high_school;

create database high_school;

use high_school;


CREATE TABLE Course (
  idCourse INTEGER NOT NULL AUTO_INCREMENT,
  Teacher_idTeacher INTEGER NOT NULL,
  nameCourse VARCHAR(30) NOT NULL,
  hoursByWeekCourse INTEGER NOT NULL,
  scheduleTimeCourse INTEGER NOT NULL,
  PRIMARY KEY(idCourse),
  INDEX Course_FKIndex1(Teacher_idTeacher)
);

CREATE TABLE Notes (
  idNotes INTEGER NOT NULL AUTO_INCREMENT,
  Enroll_idEnroll INTEGER NOT NULL,
  partialNote1Notes FLOAT NOT NULL,
  partialNote2Notes FLOAT NOT NULL,
  partialNote3Notes FLOAT NOT NULL,
  finalNoteNotes FLOAT NOT NULL,
  PRIMARY KEY(idNotes),
  INDEX Notes_FKIndex1(Enroll_idEnroll)
);

CREATE TABLE Schedule_Time (
  idSchedule_Time INTEGER NOT NULL AUTO_INCREMENT,
  Course_idCourse INTEGER NOT NULL,
  daySchedule_Time VARCHAR(30) NOT NULL,
  hourInitialSchedule_Time TIME NOT NULL,
  hourFinalSchedule_Time TIME NOT NULL,
  PRIMARY KEY(idSchedule_Time),
  INDEX Schedule_Time_FKIndex1(Course_idCourse)
);

CREATE TABLE Enroll (
  idEnroll INTEGER NOT NULL AUTO_INCREMENT,
  Course_idCourse INTEGER NOT NULL,
  Student_registrationNumberStudent INTEGER NOT NULL,
  PRIMARY KEY(idEnroll, Course_idCourse, Student_registrationNumberStudent),
  INDEX Signed_FKIndex1(Student_registrationNumberStudent),
  INDEX Signed_FKIndex2(Course_idCourse)
);

CREATE TABLE Student (
  registrationNumberStudent INTEGER NOT NULL,
  firstNameStudent VARCHAR(30) NOT NULL,
  lastNameStudent VARCHAR(30) NOT NULL,
  dateOfBirth DATE NOT NULL,
  PRIMARY KEY(registrationNumberStudent)
);

CREATE TABLE Teacher (
  idTeacher INTEGER NOT NULL AUTO_INCREMENT,
  firstNameTeacher VARCHAR(30) NULL,
  lastNameTeacher VARCHAR(30) NULL,
  dateOfBirthTeacher DATE NULL,
  PRIMARY KEY(idTeacher)
);

INSERT INTO Course values ('1', '1', 'Spanish', '4', '1');
INSERT INTO Course values ('2', '3','Scrum', '5', '3');
INSERT INTO Course values ('3', '3','Introduction to POO', '10', '2');

INSERT INTO Teacher values (default, 'Laura', 'Araque', '1991/05/19');
INSERT INTO Teacher values (default, 'Sergio', 'Munoz', '1963/04/10');
INSERT INTO Teacher values (default, 'Sergio', 'Pedraza', '1981/10/1');

INSERT INTO Student values ('1013595915', 'Juan', 'Piza', '1988/02/23');
INSERT INTO Student values ('7589654', 'Sergio Daniel', 'Ardila', '1982/10/15');
INSERT INTO Student values ('1023546984', 'Carlos', 'Rodriguez', '1969/08/01');
INSERT INTO Student values ('89562415', 'Olimpo', 'Rodriguez', '2000/02/14');
INSERT INTO Student values ('1123568940', 'Juan Camilo', 'Galvis', '1993/09/10');
INSERT INTO Student values ('75554126', 'Miguel', 'Rodriguez', '1975/04/29');
INSERT INTO Student values ('9456321', 'Laura Camila', 'Oviedo', '1996/05/19');
INSERT INTO Student values ('1023548672', 'Melissa', 'Rodriguez', '2002/06/06');
INSERT INTO Student values ('1025648954', 'Maiky', 'Bayona', '1991/08/12');
INSERT INTO Student values ('98456213', 'Sebastian Camilo', 'Galvis', '1995/01/01');

INSERT INTO Enroll values (default, 1, '98456213');
INSERT INTO Enroll values (default, 1, '1025648954');
INSERT INTO Enroll values (default, 1, '1013595915');
INSERT INTO Enroll values (default, 1, '7589654');

INSERT INTO Enroll values (default, 2, '1023548672');
INSERT INTO Enroll values (default, 2, '9456321');
INSERT INTO Enroll values (default, 2, '75554126');
INSERT INTO Enroll values (default, 2, '1123568940');

INSERT INTO Enroll values (default, 3, '89562415');
INSERT INTO Enroll values (default, 3, '1023546984');
INSERT INTO Enroll values (default, 3, '7589654');
INSERT INTO Enroll values (default, 3, '1013595915');

    
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('1', '2.5', '3.5', '4', '4');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('2', '2.5', '1.5', '4', '2.4');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('3', '2.1', '1.9', '3', '2');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('4', '5', '5', '5', '5');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('5', '0', '3', '5', '2.8');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('6', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('7', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('8', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('9', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('10', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('11', '3', '3', '3', '3');
INSERT INTO Notes (Enroll_idEnroll, partialNote1Notes, partialNote2Notes, partialNote3Notes, finalNoteNotes) values ('12', '3', '3', '3', '3');

INSERT into Schedule_Time VALUES (default, '1', 'MONDAY***', '08:00', '10:00');
INSERT into Schedule_Time VALUES (default, '1', 'FRIDAY***', '12:00', '14:00');
INSERT into Schedule_Time VALUES (default, '2', 'SATURDAY*', '08:00', '10:00');
INSERT into Schedule_Time VALUES (default, '2', 'SATURDAY*', '10:00', '12:00');
INSERT into Schedule_Time VALUES (default, '3', 'WEDNESDAY', '08:00', '10:00');
INSERT into Schedule_Time VALUES (default, '3', 'THURSDAY*', '09:00', '11:00');

SELECT co.nameCourse, te.lastNameTeacher, te.firstNameTeacher, st.lastNameStudent, st.firstNameStudent 
from Course co, Teacher te, Student st, Enroll en
where en.Course_idCourse = co.idCourse
and en.Student_registrationNumberStudent = st.registrationNumberStudent
and co.Teacher_idTeacher = te.idTeacher
order by st.lastNameStudent ASC;

SELECT co.nameCourse, count(*)/(SELECT count(*) from Enroll en where en.Course_idCourse = 1)*100 as porcentage
from Notes n, Course co, Enroll en
where n.finalNoteNotes >= 3
and n.Enroll_idEnroll = en.idEnroll
and en.Course_idCourse = co.idCourse
group by co.nameCourse;

SELECT co.nameCourse, count(*)/(SELECT count(*) from Enroll en where en.Course_idCourse = 1)*100 as porcentage
from Notes n, Course co, Enroll en
where n.finalNoteNotes < 3
and n.Enroll_idEnroll = en.idEnroll
and en.Course_idCourse = co.idCourse
group by co.nameCourse;

SELECT te.lastNameTeacher, te.firstNameTeacher,  sc.daySchedule_Time, sc.hourInitialSchedule_Time, sc.hourFinalSchedule_Time, co.nameCourse
from Course co, Teacher te, Student st, Enroll en, Schedule_Time sc
where sc.Course_idCourse = co.idCourse
and co.Teacher_idTeacher = te.idTeacher
group by lastNameTeacher, idSchedule_Time;