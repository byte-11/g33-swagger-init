package uz.pdp.g33hateoas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.g33hateoas.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}