import React from "react";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({}));

function Home() {
  const classes = useStyles();

  return (
    <>
      <h1 className={classes}>Home Screen</h1>
    </>
  );
}

export default Home;
