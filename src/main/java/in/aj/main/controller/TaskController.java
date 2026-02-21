package in.aj.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.aj.main.dto.TaskDto;
import in.aj.main.service.TaskService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class TaskController {
	public TaskService taskService;
 @GetMapping("/tasks")
 public String getAllTask(Model model)
 {
	 List<TaskDto> tasks = taskService.getAllTasks();
	 model.addAttribute("tasks", tasks);
	 return "tasks/taskList";
 }
 @GetMapping("/tasks/create")
  public String createTask(Model model)
  {
	 TaskDto taskDto = new TaskDto();
	 model.addAttribute("task", taskDto);
	 return "tasks/createTask.html";
  }
  @PostMapping("/tasks")
  public String submitTask(@ModelAttribute("task") TaskDto taskDto,Model model)
  {
	  taskService.createTask(taskDto);
	  return "redirect:/tasks?success";
  }
  @GetMapping("/tasks/delete/{id}")
  public String deleteTask(@PathVariable("id") Long id)
  {
	  taskService.deleteTask(id);
	  return "redirect:/tasks";
  }
  @GetMapping("/tasks/edit/{id}")
  public String editTask(@PathVariable("id") long id,Model model)
  {
	  TaskDto taskDto = taskService.getTaskById(id);
	  model.addAttribute("task",taskDto);
	  return "tasks/EditTask.html";
  }
  @PostMapping("/tasks/{id}")
  public String updateTask(@PathVariable("id") Long id,@ModelAttribute("task") TaskDto taskDto)
  {
	  taskDto.setId(id);
	  taskService.updateTask(taskDto);
	  return "redirect:/tasks?update";
  }
}
