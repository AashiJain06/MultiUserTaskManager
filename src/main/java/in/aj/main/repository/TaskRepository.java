package in.aj.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aj.main.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

	

}
