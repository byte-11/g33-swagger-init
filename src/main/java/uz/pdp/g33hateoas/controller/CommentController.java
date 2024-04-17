package uz.pdp.g33hateoas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.g33hateoas.ErrorResponseDTO;
import uz.pdp.g33hateoas.assambler.CommentModelAssembler;
import uz.pdp.g33hateoas.domain.Comment;
import uz.pdp.g33hateoas.repo.CommentRepository;

@RestController
@RequestMapping("/comments")
@Tag(name = "Comment APIs", description = "Comment related apis only")
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentModelAssembler commentModelAssembler;
    private final PagedResourcesAssembler<Comment> commentPagedResourcesAssembler;

    public CommentController(CommentRepository commentRepository, CommentModelAssembler commentModelAssembler, PagedResourcesAssembler<Comment> commentPagedResourcesAssembler) {
        this.commentRepository = commentRepository;
        this.commentModelAssembler = commentModelAssembler;
        this.commentPagedResourcesAssembler = commentPagedResourcesAssembler;
    }

    @Operation(summary = "Gets all Comments", description = "Comment list will available or may be empty")
    @GetMapping("/all")
    public CollectionModel<EntityModel<Comment>> getAllComments() {
        Link link = linkTo(methodOn(CommentController.class).getAllComments()).withSelfRel();
        return commentModelAssembler.toCollectionModel(commentRepository.findAll())
                .add(link);
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(
                    description = "Gets Comment by its ID",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Comment.class))
            ),
            @ApiResponse(
                    description = "Comment not available",
                    responseCode = "404",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
            )
    })
    public EntityModel<Comment> getCommentById(@PathVariable("id") Long id) {
        Comment comment = commentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        return commentModelAssembler.toModel(comment)
                .add(linkTo(methodOn(CommentController.class).getCommentById(id)).withSelfRel());
    }

    @GetMapping
    public PagedModel<EntityModel<Comment>> getAllByPage(@RequestParam(value = "page") Integer page, @RequestParam("size") Integer size) {
        Page<Comment> commentPage = commentRepository.findAll(PageRequest.of(page, size));
        return commentPagedResourcesAssembler.toModel(
                commentPage,
                commentModelAssembler,
                linkTo(methodOn(CommentController.class).getAllByPage(page, size)).withSelfRel()
        );

    }
}
