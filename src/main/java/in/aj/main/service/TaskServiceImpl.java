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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}
   
}
