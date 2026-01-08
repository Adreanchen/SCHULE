<?php

namespace app\controllers;

use app\models\Lieferanten;
use app\models\LieferantenSearch;
use yii\web\Controller;
use yii\web\NotFoundHttpException;
use yii\filters\VerbFilter;

/**
 * LieferantenController implements the CRUD actions for Lieferanten model.
 */
class LieferantenController extends Controller
{
    /**
     * @inheritDoc
     */
    public function behaviors()
    {
        return array_merge(
            parent::behaviors(),
            [
                'verbs' => [
                    'class' => VerbFilter::className(),
                    'actions' => [
                        'delete' => ['POST'],
                    ],
                ],
            ]
        );
    }

    /**
     * Lists all Lieferanten models.
     *
     * @return string
     */
    public function actionIndex()
    {
        $searchModel = new LieferantenSearch();
        $dataProvider = $searchModel->search($this->request->queryParams);

        return $this->render('index', [
            'searchModel' => $searchModel,
            'dataProvider' => $dataProvider,
        ]);
    }

    /**
     * Displays a single Lieferanten model.
     * @param int $LieferantenID Lieferanten ID
     * @return string
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionView($LieferantenID)
    {
        return $this->render('view', [
            'model' => $this->findModel($LieferantenID),
        ]);
    }

    /**
     * Creates a new Lieferanten model.
     * If creation is successful, the browser will be redirected to the 'view' page.
     * @return string|\yii\web\Response
     */
    public function actionCreate()
    {
        $model = new Lieferanten();

        if ($this->request->isPost) {
            if ($model->load($this->request->post()) && $model->save()) {
                return $this->redirect(['view', 'LieferantenID' => $model->LieferantenID]);
            }
        } else {
            $model->loadDefaultValues();
        }

        return $this->render('create', [
            'model' => $model,
        ]);
    }

    /**
     * Updates an existing Lieferanten model.
     * If update is successful, the browser will be redirected to the 'view' page.
     * @param int $LieferantenID Lieferanten ID
     * @return string|\yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionUpdate($LieferantenID)
    {
        $model = $this->findModel($LieferantenID);

        if ($this->request->isPost && $model->load($this->request->post()) && $model->save()) {
            return $this->redirect(['view', 'LieferantenID' => $model->LieferantenID]);
        }

        return $this->render('update', [
            'model' => $model,
        ]);
    }

    /**
     * Deletes an existing Lieferanten model.
     * If deletion is successful, the browser will be redirected to the 'index' page.
     * @param int $LieferantenID Lieferanten ID
     * @return \yii\web\Response
     * @throws NotFoundHttpException if the model cannot be found
     */
    public function actionDelete($LieferantenID)
    {
        $this->findModel($LieferantenID)->delete();

        return $this->redirect(['index']);
    }

    /**
     * Finds the Lieferanten model based on its primary key value.
     * If the model is not found, a 404 HTTP exception will be thrown.
     * @param int $LieferantenID Lieferanten ID
     * @return Lieferanten the loaded model
     * @throws NotFoundHttpException if the model cannot be found
     */
    protected function findModel($LieferantenID)
    {
        if (($model = Lieferanten::findOne(['LieferantenID' => $LieferantenID])) !== null) {
            return $model;
        }

        throw new NotFoundHttpException(Yii::t('app', 'The requested page does not exist.'));
    }
}
