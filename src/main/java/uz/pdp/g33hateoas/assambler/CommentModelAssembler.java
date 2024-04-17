package uz.pdp.g33hateoas.assambler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;
import uz.pdp.g33hateoas.controller.CommentController;
import uz.pdp.g33hateoas.domain.Comment;

@Component
public class CommentModelAssembler implements RepresentationModelAssembler<Comment, EntityModel<Comment>> {
    @Override
    public EntityModel<Comment> toModel(Comment entity) {
        return EntityModel.of(entity)
                .add(linkTo(methodOn(CommentController.class).getCommentById(entity.getId())).withSelfRel());
    }

}
