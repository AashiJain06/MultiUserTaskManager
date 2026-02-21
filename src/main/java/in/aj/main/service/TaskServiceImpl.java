package in.aj.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import in.aj.main.dto.TaskDto;
import in.aj.main.entity.Task;
import in.aj.main.repository.TaskRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{
	private TaskRepository taskRepository;
	private ModelMapper modelMapper;
	@Override
	public void updateTask(TaskDto taskDto) {
		taskRepository.save(modelMapper.map(taskDto,Task.class));
		
	}

	@Override
	public List<TaskDto> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		return  tasks.stream().map((task)->modelMapper.map(task,TaskDto.class)).collect(Collectors.toList());
	}

	@Override
	public void createTask(TaskDto taskDto) {
		Task task = modelMapper.map(taskDto,Task.class);
		taskRepository.save(task);
		
	}

	@Override
	public TaskDto getTaskById(Long id) {
		Task task = taskRepository.findById(id).get();
		TaskDto taskDto = modelMapper.map(task, TaskDto.class);
		return taskDto;
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

	

	
	
   
}
