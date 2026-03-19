# CRC Cards Explanation

TaskManager collaborates with Task because it is responsible for storing, retrieving, and managing Task objects. It depends on Task to access task details such as ID and status.

Task does not collaborate with TaskManager because its responsibility is only to store and manage its own data (taskId, description, and status). It has no need to interact with or manage other tasks.