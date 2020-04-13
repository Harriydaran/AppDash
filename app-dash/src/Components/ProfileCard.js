import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Typography from "@material-ui/core/Typography";

const useStyles = makeStyles({
  media: {
    height: 300,
    minWidth: 200,
  },
});

export default function ProfileCard(props) {
  const classes = useStyles();

  if (props.currentUser.photoURL != null) {
    return (
      <>
        <Card className={classes.root} elevation={2}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              image={props.currentUser.photoURL}
              title={props.currentUser.displayName}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                {props.currentUser.displayName}
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                {props.currentUser.email}
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </>
    );
  } else {
    return (
      <>
        <Card className={classes.root}>
          <CardActionArea>
            <CardMedia
              className={classes.media}
              image="https://source.unsplash.com/random"
              title={props.currentUser.displayName}
            />
            <CardContent>
              <Typography gutterBottom variant="h5" component="h2">
                {props.currentUser.displayName}
              </Typography>
              <Typography variant="body2" color="textSecondary" component="p">
                {props.currentUser.email}
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </>
    );
  }
}
