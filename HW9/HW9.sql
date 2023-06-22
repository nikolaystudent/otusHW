create database OtusHW9;

create table questions 
(
	question_number serial       primary key,
	question_text   varchar(150) not null unique
)

create table answer_options 
(
	answer_number serial       primary key,
	answer_text   varchar(150) not null unique,
	corret_is	  boolean      not null,	
	question	  integer      references questions (question_number)
)

insert into questions (question_text)
values ('Является ли сериал Кремниевая долина клевым?'), 
	   ('Что из перечисленного является лучшим подарком на любой праздник?'),
	   ('Кого из перечисленных можно назвать величайшим в мире актером?')

insert into answer_options (answer_text, corret_is, question)
values ('Да!', true, 1), 
	   ('Не уверен', false, 1),
	   ('Нет', false, 1),
	   ('Деньги', false, 2),
	   ('Настольная игра', true, 2),
	   ('Книга', false, 2),
	   ('Брэд Питт', false, 3),
	   ('Аль Пачино', false, 3),
	   ('Райан Гослинг', true, 3)

select questions.*, answer_options.answer_text, answer_options.corret_is
from questions
join answer_options on answer_options.question = questions.question_number